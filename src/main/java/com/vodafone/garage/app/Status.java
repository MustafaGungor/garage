package com.vodafone.garage.app;




import com.vodafone.garage.config.BaseConfig;
import com.vodafone.garage.exception.NotFoundException;
import com.vodafone.garage.exception.ServerErrorException;
import com.vodafone.garage.model.Car;

import java.util.*;
import java.util.stream.Collectors;

public class Status extends BaseConfig {

	@Override
	public void setPark(String[] commandArray) throws ServerErrorException {
		try {
			if(!parkingList.isEmpty() || parkingList != null) {
				Car car;
				Set<Car> a = new HashSet<Car>(parkingList.values());
				Map<Car, List<Integer>> valueMap = parkingList.keySet().stream().collect(Collectors.groupingBy(parkingList::get));

				valueMap.entrySet().stream().forEach((val)->{
					System.out.println(val.getKey().getPlakaNo() + "\t" + val.getKey().getColour() + "\t" + Arrays.deepToString(val.getValue().toArray(new Integer[0])).toString());
					lastStateList.add(val.getKey().getPlakaNo() + "\t" + val.getKey().getColour() + "\t" + Arrays.deepToString(val.getValue().toArray(new Integer[0])).toString());
				});

			} 
			else {
				throw new NotFoundException("Parking Lot Not Found. Create one first");
			}

		}
		catch (Exception e) {
			throw new ServerErrorException(e.getMessage(), e);
		}
	}
}