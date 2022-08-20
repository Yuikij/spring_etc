package aki.demo.util;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.tiff.TiffField;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata;
import org.apache.commons.imaging.formats.tiff.constants.ExifTagConstants;
import org.apache.commons.imaging.formats.tiff.constants.TiffTagConstants;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Exif {
    public static void main(String[] args) throws IOException, ImageReadException {
        File file = new File("D:\\code\\xiangmu\\WebSocketFMp4Player\\org_1ffd09849acec353_1658729844000.jpg");
        InputStream in = new FileInputStream(file);
        ImageMetadata metadata = Imaging.getMetadata(in,"123");
        final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
        printTagInt(jpegMetadata, TiffTagConstants.TIFF_TAG_IMAGE_WIDTH);
        printTagInt(jpegMetadata, TiffTagConstants.TIFF_TAG_IMAGE_LENGTH);

        // print out various interesting EXIF tags.
        printTagString(jpegMetadata, TiffTagConstants.TIFF_TAG_MAKE);
        printTagString(jpegMetadata, TiffTagConstants.TIFF_TAG_MODEL);

        printTagValue(jpegMetadata, ExifTagConstants.EXIF_TAG_DATE_TIME_ORIGINAL);
        printTagValue(jpegMetadata, ExifTagConstants.EXIF_TAG_DATE_TIME_DIGITIZED);
        printTagValue(jpegMetadata, TiffTagConstants.TIFF_TAG_DATE_TIME);
        // simple interface to GPS data
        final TiffImageMetadata exifMetadata = jpegMetadata.getExif();
        if (null != exifMetadata) {
            final TiffImageMetadata.GPSInfo gpsInfo = exifMetadata.getGPS();
            if (null != gpsInfo) {
                final double longitude = gpsInfo.getLongitudeAsDegreesEast();
                final double latitude = gpsInfo.getLatitudeAsDegreesNorth();
                System.out.println("    "
                        + "GPS Longitude (Degrees East): " + longitude);
                System.out.println("    "
                        + "GPS Latitude (Degrees North): " + latitude);
            }
        }
    }

    private static void printTagString(final JpegImageMetadata jpegMetadata, final TagInfo tagInfo) {
        final TiffField field = jpegMetadata.findEXIFValueWithExactMatch(tagInfo);
        try {
            System.out.println(tagInfo.name + ": "
                    + field.getStringValue());
        } catch (ImageReadException e) {
            e.printStackTrace();
        }
    }

    private static void printTagInt(final JpegImageMetadata jpegMetadata, final TagInfo tagInfo) {
        final TiffField field = jpegMetadata.findEXIFValueWithExactMatch(tagInfo);
        try {
            System.out.println(tagInfo.name + ": "
                    + field.getIntValue());
        } catch (ImageReadException e) {
            e.printStackTrace();
        }
    }

    private static void printTagValue(final JpegImageMetadata jpegMetadata,
                                      final TagInfo tagInfo) {
        final TiffField field = jpegMetadata.findEXIFValueWithExactMatch(tagInfo);
        if (field == null) {
            System.out.println(tagInfo.name + ": " + "Not Found.");
        } else {
            try {
                System.out.println(tagInfo.name + ": "
                        + field.getValue());
            } catch (ImageReadException e) {
                e.printStackTrace();
            }
        }
    }
}
