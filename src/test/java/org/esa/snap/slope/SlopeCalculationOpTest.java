package org.esa.snap.slope;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SlopeCalculationOpTest {

    @Test
    public void computeSlopeAndAspect() {
        float[] altitude = new float[]{
                10.0f, 10.0f, 15.0f, 17.5f, 12.5f, 12.5f,
                10.0f, 10.0f, 15.0f, 17.5f, 12.5f, 12.5f,
                12.0f, 12.0f, 14.0f, 16.0f, 13.0f, 13.0f,
                13.0f, 13.0f, 11.0f, 13.0f, 14.0f, 14.0f,
                14.0f, 14.0f, 12.0f, 14.0f, 11.0f, 11.0f,
                14.0f, 14.0f, 12.0f, 14.0f, 11.0f, 11.0f};
        final float[] slopeAndAspect_7 = SlopeCalculationOp.computeSlopeAndAspect(altitude, 7, 10, 6);
        final float[] slopeAndAspect_8 = SlopeCalculationOp.computeSlopeAndAspect(altitude, 8, 10, 6);
        final float[] slopeAndAspect_10 = SlopeCalculationOp.computeSlopeAndAspect(altitude, 10, 10, 6);
        final float[] slopeAndAspect_15 = SlopeCalculationOp.computeSlopeAndAspect(altitude, 15, 10, 6);
        final float[] slopeAndAspect_22 = SlopeCalculationOp.computeSlopeAndAspect(altitude, 22, 10, 6);
        final float[] slopeAndAspect_25 = SlopeCalculationOp.computeSlopeAndAspect(altitude, 25, 10, 6);
        final float[] slopeAndAspect_27 = SlopeCalculationOp.computeSlopeAndAspect(altitude, 27, 10, 6);
        final float[] slopeAndAspect_28 = SlopeCalculationOp.computeSlopeAndAspect(altitude, 28, 10, 6);

        float[] expectedSlope = new float[]{
                0.21798114f, 0.32035214f, 0.11440312f, 0.22131443f,
                0.10711748f, 0.22345093f, 0.14396477f, 0.124354996f,
                0.070593186f, 0.070593186f, 0.11134102f, 0.11134102f,
                0.11134102f, 0.049958397f, 0.0f, 0.14048971f};
        float[] expectedAspect = {
                4.9984402f, 4.6558456f, 1.96140337f, 1.57079637f,
                -0.95054686f, -2.12064958f, 3.01189017f, 1.57079637f,
                0.78539819f, -2.3561945f, -2.67794514f, 2.67794514f,
                1.10714877f, -0.f, Float.NaN, 2.3561945f};

        assertEquals(slopeAndAspect_7[0], expectedSlope[0], 1e-7);
        assertEquals(slopeAndAspect_8[0], expectedSlope[1], 1e-7);
        assertEquals(slopeAndAspect_10[0], expectedSlope[3], 1e-7);
        assertEquals(slopeAndAspect_22[0], expectedSlope[11], 1e-7);
        assertEquals(slopeAndAspect_25[0], expectedSlope[12], 1e-7);
        assertEquals(slopeAndAspect_27[0], expectedSlope[14], 1e-7);
        assertEquals(slopeAndAspect_28[0], expectedSlope[15], 1e-7);

        assertEquals(slopeAndAspect_7[1], expectedAspect[0], 1e-8);
        assertEquals(slopeAndAspect_8[1], expectedAspect[1], 1e-8);
        assertEquals(slopeAndAspect_10[1], expectedAspect[3], 1e-8);
        assertEquals(slopeAndAspect_15[1], expectedAspect[6], 1e-8);
        assertEquals(slopeAndAspect_22[1], expectedAspect[11], 1e-8);
        assertEquals(slopeAndAspect_25[1], expectedAspect[12], 1e-8);
        assertEquals(slopeAndAspect_27[1], expectedAspect[14], 1e-8);
        assertEquals(slopeAndAspect_28[1], expectedAspect[15], 1e-8);
    }

    @Test
    public void testComputeOrientation() {
        float[] latitudes = new float[]{50.0f, 50.01f, 50.02f, 50.03f,
                50.1f, 50.11f, 50.12f, 50.13f,
                50.2f, 50.21f, 50.22f, 50.23f,
                50.3f, 50.31f, 50.32f, 50.33f};
        float[] longitudes = new float[]{10.0f, 10.2f, 10.4f, 10.6f,
                10.01f, 10.21f, 10.41f, 10.61f,
                10.02f, 10.22f, 10.42f, 10.62f,
                10.03f, 10.23f, 10.43f, 10.63f};
        final float orientation_1 = SlopeCalculationOp.computeOrientation(latitudes, longitudes, 1);
        final float orientation_2 = SlopeCalculationOp.computeOrientation(latitudes, longitudes, 2);
        final float orientation_5 = SlopeCalculationOp.computeOrientation(latitudes, longitudes, 5);
        final float orientation_6 = SlopeCalculationOp.computeOrientation(latitudes, longitudes, 6);
        final float orientation_9 = SlopeCalculationOp.computeOrientation(latitudes, longitudes, 9);
        final float orientation_10 = SlopeCalculationOp.computeOrientation(latitudes, longitudes, 10);
        final float orientation_13 = SlopeCalculationOp.computeOrientation(latitudes, longitudes, 13);
        final float orientation_14 = SlopeCalculationOp.computeOrientation(latitudes, longitudes, 14);
        assertEquals(-0.07763171, orientation_1, 1e-8);
        assertEquals(-0.07764761, orientation_2, 1e-8);
        assertEquals(-0.07779299, orientation_5, 1e-8);
        assertEquals(-0.07780917, orientation_6, 1e-8);
        assertEquals(-0.07795518, orientation_9, 1e-8);
        assertEquals(-0.07797144, orientation_10, 1e-8);
        assertEquals(-0.07811809, orientation_13, 1e-8);
        assertEquals(-0.07813445, orientation_14, 1e-8);
    }

    @Test
    public void testComputeDistance() {
        // numbers from https://www.movable-type.co.uk/scripts/latlong.html
        double lat1 = 50.0 + 3.0/60.0 + 59.0/3600.0;
        double lon1 = -5.0 - 42.0/60.0 - 53.0/3600.0;
        double lat2 = 58.0 + 38.0/60.0 + 38.0/3600.0;
        double lon2 = -3.0 - 4.0/60.0 - 12.0/3600.0;

        double distance = SlopeCalculationOp.computeDistance(lat1, lon1, lat2, lon2);
        assertEquals(968.9, distance, 0.1);
    }
}
