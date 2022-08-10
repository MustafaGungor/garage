package com.vodafone.garage.app;

import com.vodafone.garage.config.BaseConfig;
import com.vodafone.garage.enums.CarType;
import com.vodafone.garage.exception.NotFoundException;
import com.vodafone.garage.exception.ServerErrorException;
import com.vodafone.garage.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Park extends BaseConfig {

	@Override
	public void setPark(String[] commandArray) throws ServerErrorException {
		try {
			if(!parkingList.isEmpty() || parkingList != null) {
				Car car = new Car(commandArray[0],commandArray[1], commandArray[2], CarType.valueOf(commandArray[3]));
				List<Integer> totalPlacesLeft = left;
				if(CarType.valueOf(commandArray[3]).getValue() >= totalPlacesLeft.size()) {
					System.out.println("Garage is full");
					lastStateList.add("Garage is full");
				} else {
					Integer parkingSlot = totalPlacesLeft.get(0);
					if(totalPlacesLeft.size() <= total_size ) {
						int area = CarType.valueOf(commandArray[3]).getValue();
						parkingSlot = makeSequence(parkingSlot+1,area,totalPlacesLeft);
						if(parkingSlot == -1){
							System.out.println("Garage is full");
							lastStateList.add("Garage is full");
							return;
						}
						if(parkingList.size() == 0){
							for (int i = 0; i < area; i++) {
								var increase = i + 1;
								parkingList.put(increase,car);
								((ArrayList) totalPlacesLeft).removeIf((val)-> val.equals(increase));
							}
						}else {
							for (int i = 0; i < area; i++) {
								var value = parkingSlot + i;
								parkingList.put(value, car);
								((ArrayList) totalPlacesLeft).removeIf((val)-> val.equals(value));
							}
						}
						String message = "Allocated " + (area == 1 ? "1 slot." : area+" slots.");
						System.out.println(message);
						lastStateList.add(message);
					}
				}
			}
			else {
				throw new NotFoundException("Parking Not Found. Create one first");
			}

		}
		catch (Exception e) {
			throw new ServerErrorException(e.getMessage(), e);
		}
	}

	/**
	 *
	 * @param begin
	 * @param size
	 * @param totalPlacesLeft
	 * @return
	 */
	public Integer makeSequence(int begin, int size, List<Integer> totalPlacesLeft) {
		try {
			if(totalPlacesLeft.size() == 10) return 1;
			List<Integer> ret = new ArrayList<>(begin + size - begin + 1);
			for (int i=begin; i<begin+size; i++) {
				ret.add(i);
			}
			if(totalPlacesLeft.stream().max((i,j)->i.compareTo(j)).get()==begin){
				return -1;
			}
			return totalPlacesLeft.containsAll(ret) ? begin : makeSequence(begin+1,size,totalPlacesLeft);
		}catch (Exception e){
			return -1;
		}
	}
}
