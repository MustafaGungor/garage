package com.vodafone.garage.app;

import com.vodafone.garage.config.BaseConfig;
import com.vodafone.garage.exception.ServerErrorException;
import com.vodafone.garage.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Leave extends BaseConfig {

	@Override
	public void setPark(String[] commandArray) throws ServerErrorException {
		try {
			if(!parkingList.isEmpty() || parkingList != null) {
				Map<Car, List<Integer>> valueMap = parkingList.keySet().stream().collect(Collectors.groupingBy(parkingList::get));
				Integer parkingLotSpaceNumber = Integer.parseInt(commandArray[1]);
				//var removeValues = valueMap.entrySet().stream().filter((val)-> val.getValue().contains(parkingLotSpaceNumber)).collect(Collectors.toList());
				var removeValues = valueMap.values().stream().collect(Collectors.toList()).get(parkingLotSpaceNumber-1);
				ArrayList<Integer> placesLeft = left;
				if(removeValues.size() != 0){
					removeValues.forEach((val)-> {
						List<Integer> values = Collections.singletonList(val);
						values.forEach(val2 -> {
							parkingList.remove(val2);
							System.out.println("Slot number "+val2+" is free");
							lastStateList.add("Slot number "+val2+" is free");
							placesLeft.add(val2);
							Collections.sort(placesLeft);
							left = placesLeft;
						});
					});
				}
			}
		}
		catch (Exception e) {
			throw new ServerErrorException(e.getMessage(), e);
		}
	}	
}
