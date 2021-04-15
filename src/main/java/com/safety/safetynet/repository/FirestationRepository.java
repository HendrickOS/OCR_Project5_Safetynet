package com.safety.safetynet.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.safety.safetynet.database.DataBase;
import com.safety.safetynet.model.Firestation;

@Component
public class FirestationRepository extends BaseRepository implements IFirestationRepository {

	@Override
	public void addFirestation(Firestation firestation) {
		DataBase.getInstance().getStore().getFirestations().add(firestation);
	}

	@Override
	public void updateFirestation(Firestation firestation) {
		List<Firestation> listFirestations = DataBase.getInstance().getStore().getFirestations();
		for (Firestation f : listFirestations) {
			if (f.getAddress().equalsIgnoreCase(firestation.getAddress())
					&& f.getStation().equalsIgnoreCase(firestation.getStation())) {
				f.update(firestation);
				break;
			}
		}
	}

	@Override
	public void deleteFirestation(Firestation firestation) {
		List<Firestation> listFirestations = DataBase.getInstance().getStore().getFirestations();
		for (Firestation f : listFirestations) {
			if (f.getAddress().equalsIgnoreCase(firestation.getAddress())
					&& f.getStation().equalsIgnoreCase(firestation.getStation())) {
				listFirestations.remove(f);
				break;
			}
		}
	}

	public List<Firestation> list() {
		return DataBase.getInstance().getStore().getFirestations();
	}

}
