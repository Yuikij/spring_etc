package com.spring.test;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.expression.*;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

@SpringBootTest
@Log4j2
public class ExpressionTest {

    String json = "[\n" +
            "   {\n" +
            "    \"baseAlgorithm\":null,\n" +
            "    \"comparisonOperator\":\"\",\n" +
            "    \"logicalOperator\":\"\",\n" +
            "    \"group\":[\n" +
            "      {\n" +
            "        \"baseAlgorithm\":{\n" +
            "          \"value\":\"A\"\n" +
            "        },\n" +
            "        \"comparisonOperator\":\"\",\n" +
            "        \"logicalOperator\":\"and\",\n" +
            "        \"group\":[\n" +
            "          {\n" +
            "            \"baseAlgorithm\":{\n" +
            "              \"value\":\"A\"\n" +
            "            },\n" +
            "            \"comparisonOperator\":\"\",\n" +
            "            \"logicalOperator\":\"and\"\n" +
            "           },   \n" +
            "           {\n" +
            "            \"baseAlgorithm\":{\n" +
            "              \"value\":\"B\"\n" +
            "            },\n" +
            "            \"comparisonOperator\":\"\",\n" +
            "            \"logicalOperator\":\"or\"\n" +
            "           }\n" +
            "        ]\n" +
            "       },   \n" +
            "       {\n" +
            "        \"baseAlgorithm\":{\n" +
            "          \"value\":\"C\"\n" +
            "        },\n" +
            "        \"comparisonOperator\":\"\",\n" +
            "        \"logicalOperator\":\"or\"\n" +
            "       }\n" +
            "    ]\n" +
            "   }\n" +
            "   ,\n" +
            "   {\n" +
            "    \"baseAlgorithm\":null,\n" +
            "    \"comparisonOperator\":\"\",\n" +
            "    \"logicalOperator\":\"\",\n" +
            "    \"group\":[\n" +
            "      {\n" +
            "        \"baseAlgorithm\":{\n" +
            "          \"value\":\"C\"\n" +
            "        },\n" +
            "        \"comparisonOperator\":\"\",\n" +
            "        \"logicalOperator\":\"and\"\n" +
            "       },   \n" +
            "       {\n" +
            "        \"baseAlgorithm\":{\n" +
            "          \"value\":\"D\"\n" +
            "        },\n" +
            "        \"comparisonOperator\":\"\",\n" +
            "        \"logicalOperator\":\"or\"\n" +
            "       }\n" +
            "    ]\n" +
            "   }\n" +
            "   ,\n" +
            "   {\n" +
            "    \"baseAlgorithm\":{\n" +
            "          \"value\":\"B\"\n" +
            "        },\n" +
            "    \"comparisonOperator\":\"\",\n" +
            "    \"logicalOperator\":\"\"\n" +
            "   }\n" +
            "]\n" +
            "\n" +
            "\n";
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Roles{
        BaseAlgorithm baseAlgorithm;
        String comparisonOperator;
        String logicalOperator;
        List<Roles> group;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BaseAlgorithm{
        String value;

        public String hashCodeStr() {
            return this.value;
        }
    }

    @Data
    @AllArgsConstructor
    static class BaseAlgorithmCell{
        BaseAlgorithm baseAlgorithm;
        String comparisonOperator;

        public boolean execute(){
            if (baseAlgorithm.getValue().equals("A")){
                return true;
            }else if (baseAlgorithm.getValue().equals("B")){
                return false;
            }else if (baseAlgorithm.getValue().equals("C")){
                return true;
            }else{
                return false;
            }
        }
        public static BaseAlgorithmCell fromHashCodeStr(String hashCodeStr) {
            return new BaseAlgorithmCell(new BaseAlgorithm(hashCodeStr),null);
        }

        public String hashCodeStr() {
            return baseAlgorithm.getValue();
        }
    }

    @Test
    public void testRun() throws JsonProcessingException {
//        "( f1+1 > 18 ) and f1 < 60");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Roles> roles = objectMapper.readValue(json, new TypeReference<List<Roles>>() {});
        Set<String> baseAlgorithmCellSet = new HashSet<>();
        String value = resolve(roles, baseAlgorithmCellSet).getValue();

        JSONObject obj = new JSONObject();
        baseAlgorithmCellSet.forEach(e->{
            obj.put(e,BaseAlgorithmCell.fromHashCodeStr(e).execute());
        });
        System.out.println(value);
        log.info("前置结果：A true,B false,C true,D false");
        log.info("解析表达式:{}",value);
        log.info("执行结果：{}",evaluate(value,obj));

    }
    private static final ExpressionParser parser = new SpelExpressionParser();
    public static boolean evaluate(String expressionString, JSONObject context) {
        Expression expression = parser.parseExpression(expressionString);
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext(context);
        evaluationContext.addPropertyAccessor(new JSONObjectPropertyAccessor());
        return Boolean.TRUE.equals(expression.getValue(evaluationContext, Boolean.class));
    }

    @Data
    public static class ResolveRes{
        String value;
        String lastLogicalOperator;

        public String hashCodeStr() {
            return this.value;
        }
    }

    public  ResolveRes resolve(List<Roles> roles,Set<String> baseAlgorithmCellSet){
        ResolveRes res = new ResolveRes();
        StringBuffer expressionStr = new StringBuffer();

        for (int i = 0; i < roles.size(); i++) {
            Roles e = roles.get(i);
            BaseAlgorithmCell baseAlgorithmCell = new BaseAlgorithmCell(e.getBaseAlgorithm(),e.getComparisonOperator());
            if (e.getBaseAlgorithm()!=null){
                expressionStr.append(baseAlgorithmCell.hashCodeStr()).append(" ");
                baseAlgorithmCellSet.add(baseAlgorithmCell.hashCodeStr());
            }
            if (e.getLogicalOperator()!=null && !e.getLogicalOperator().equals("")){
                if (i==roles.size()-1){
                    res.setLastLogicalOperator(e.getLogicalOperator());
                }else {
                    expressionStr.append(e.getLogicalOperator()).append(" ");

                }
            }
            if (e.getGroup()!=null){
                expressionStr.append("(").append(" ");
                ResolveRes resolveGroup = resolve(e.getGroup(),baseAlgorithmCellSet);
                expressionStr.append(resolveGroup.getValue());
                expressionStr.append(")").append(" ");
                if (resolveGroup.getLastLogicalOperator()!=null&& !resolveGroup.getLastLogicalOperator().equals("null")){
                    expressionStr.append(resolveGroup.getLastLogicalOperator()).append(" ");
                }
            }
        }
        res.setValue(expressionStr.toString());
        return res;
    }

    public static class JSONObjectPropertyAccessor implements PropertyAccessor {
        @Override
        public Class<?>[] getSpecificTargetClasses() {
            return new Class<?>[] { JSONObject.class };
        }

        @Override
        public boolean canRead(EvaluationContext context, Object target, String name) throws AccessException {
            return target instanceof JSONObject;
        }

        @Override
        public TypedValue read(EvaluationContext context, Object target, String name) throws AccessException {
            JSONObject json = (JSONObject) target;
            return new TypedValue(json.get(name));
        }

        @Override
        public boolean canWrite(EvaluationContext context, Object target, String name) throws AccessException {
            return false;
        }

        @Override
        public void write(EvaluationContext context, Object target, String name, Object newValue) throws AccessException {
            throw new UnsupportedOperationException("Write operation is not supported");
        }
    }

}
