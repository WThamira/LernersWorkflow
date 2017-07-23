package com.learners.models.enums;

import java.util.Arrays;
import java.util.List;

public enum VehicleClasses {
	
	A1("Light motor cycles of which Engine Capacity does not exceeds 100CC","A1","G1","http://www.motortraffic.gov.lk/web/web/images/stories/1.png","D"),
	A("Motorcycles of which Engine capacity exceeds 100CC","A","A1-G1","http://www.motortraffic.gov.lk/web/web/images/stories/2.png","D"),
	B1("Motor Tricycle or van of which tare does not exceed 500kg and Gross vehicle weight does not exceed 1000 kg: Motor vehicle in this class include an invalid carriage","B1","G1","http://www.motortraffic.gov.lk/web/web/images/stories/3.png","E-F"),
	B("Dual purpose Motor vehicle of which Gross Vehicle Weight does not exceed 3500kg and the seating capacity does not exceed 9 seats inclusive of the driver’s seat, which may be combined with a trailer of which maximum authorized tare does not exceed 750kg: Motor vehicle in this class include and invalid carriage and all cars where the seating capacity does not exceed 9 seats inclusive of the Driver’s seat.","B","G1","http://www.motortraffic.gov.lk/web/web/images/stories/4.png","C-C1"),
	C1("Light Motor Lorry – Motor Lorry of which Gross Vehicle Weight exceeds 3500 kg and does not exceed 17000kg: Motor vehicles in this class may be combined with a trailer having maximum authorized tare which does not exceed 750kg: Motor vehicles of this class include a motor ambulance and motor hearses.","C1","B-G1","http://www.motortraffic.gov.lk/web/web/images/stories/5.png","B1"),
	C("Motor Lorry of which Gross vehicle Weight is more than 1700kg; may be combine with a trailer having a maximum authorized tare which does not exceed 750kg","C","C1-B-J-G-G1","http://www.motortraffic.gov.lk/web/web/images/stories/6.png","B"),
	CE("Heavy Motor Lorry; combination of motor lorry and trailer (s) including articulated vehicles and its trailer (s) of which maximum authorized tare of the trailer exceeds 750kg and gross vehicle weight exceeds 3500kg","CE","C-C1-B-B1-G-G1-J","http://www.motortraffic.gov.lk/web/web/images/stories/7.png","B"),
	D1("Light Motor Coach- Motor vehicles used for the carriage of persons and having seating capacity of not less than 9 seats and not more than 33 seats inclusive of the driver’s seat; motor vehicle in this class may be combined with a trailer having a maximum authorized tare which does not exceed 750kg","D1","C1-B-B1-G-G1","http://www.motortraffic.gov.lk/web/web/images/stories/8.png","A1"),
	D("Motor Coach where the seating capacity does not exceed 33 seats inclusive of the driver’s seat; motor vehicles in this class may be combined with a trailer having a maximum authorized tare which does not exceed 750kg","D","D1-C-C1-B-B1-G-G1-J","http://www.motortraffic.gov.lk/web/web/images/stories/9.png","A"),
	DE("Heavy Motor Coach – Combination of motor coach having a seating capacity of 33 seats inclusive of the driver’s seat and it’s trailer having maximum authorized tare exceeding 750kg or a combination of two motor coaches","DE","D-D1-C-C1-CE-B-B1-G-G1-J","http://www.motortraffic.gov.lk/web/web/images/stories/10.png","null"),
	G1("Hand Tractors - Two Wheel Tractor with a Trailer","G1","null","http://www.motortraffic.gov.lk/web/web/images/stories/11.png","G1"),
	G("Land Vehicle - Agricultural Land Vehicle with or without a trailer","G","G1","http://www.motortraffic.gov.lk/web/web/images/stories/12.png","G"),
	J("Special purpose Vehicle, Vehicle used for construction, loading & unloading excluding motor lorries, light motor lorries and heavy motor lorries, equipped with construction equipment and equipment for loading and unloading goods","J","G1","http://www.motortraffic.gov.lk/web/web/images/stories/13.png","null"),
	PT("Moped","null","null","null","null");
	
	private List<String> value;

	private VehicleClasses(String... value) {
		this.value = Arrays.asList(value);
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}
