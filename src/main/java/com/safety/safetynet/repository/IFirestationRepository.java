package com.safety.safetynet.repository;

import com.safety.safetynet.model.Firestation;

public interface IFirestationRepository {

	public void addFirestation(Firestation firestation);

	public void updateFirestation(Firestation firestation);

	public void deleteFirestation(Firestation firestation);

}
