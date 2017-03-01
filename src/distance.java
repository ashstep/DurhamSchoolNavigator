package DurhamHousing;
/**
 * Class calculates distance between given points
 * Used to sort by distance nearest schools matching preferences
 * 
 * @author Ashka Stephen
 */

class distance {
	/**
	 * @param lat1, lat2, lon1, lon2 are the coordinates (latitude and longitude) for two points
	 * @param unit in which user desires return value (i.e. k = kilometers, M = "miles")
	 * @return distance between two points in given units
	 */
	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
			} 
		else if (unit == "N") {
			dist = dist * 0.8684;
			}
		return (dist);
		}
	
	/**
	 * Degree to Radian Converter
	 * 
	 * @param Degrees to convert
	 * @return Radian equivalent
	 */

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
		}	
	
	/**
	 * Radian to Degree Converter
	 * 
	 * @param Radians as a Double to convert
	 * @return Degree equivalent
	 */
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
		}

	/**
	 * TEST
	 */
	public static void main (String[] args) throws java.lang.Exception{
		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "M") + " Miles\n");
		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "K") + " Kilometers\n");
		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "N") + " Nautical Miles\n");
		}
	}
