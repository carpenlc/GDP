package mil.nga.npd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mil.nga.elevation.GetElevationAt;
import mil.nga.npd.utils.TypeConverter;

public class TestPointPopulation {

	@Test
	public void testPointPopulation() {
		GetElevationAt request = new GetElevationAt();
		assertEquals(request.getPts().size(), 0);
		request.getPts().add(
				TypeConverter.convert(
						new GeodeticCoordinate.GeodeticCoordinateBuilder()
							.lat(10.0)
							.lon(15.0)
							.build()));
		assertEquals(request.getPts().size(), 1);
		request.getPts().add(
				TypeConverter.convert(
						new GeodeticCoordinate.GeodeticCoordinateBuilder()
							.lat(11.0)
							.lon(16.0)
							.build()));
		assertEquals(request.getPts().size(), 2);
		request.getPts().add(
				TypeConverter.convert(
						new GeodeticCoordinate.GeodeticCoordinateBuilder()
							.lat(12.0)
							.lon(17.0)
							.build()));
		assertEquals(request.getPts().size(), 3);
	}
}
