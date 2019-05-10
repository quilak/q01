package q01a.common.model.metadata;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access=AccessLevel.PRIVATE)
public abstract class Q01PersistableObjectCodes {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTANTS
/////////////////////////////////////////////////////////////////////////////////////////
	public final static long PERSISTABLE_OBJ_TYPE_BASE_CODE = 1;
	
	public final static long PERSON_OBJ_TYPE_CODE = PERSISTABLE_OBJ_TYPE_BASE_CODE + 10;
	public final static long TEAM_OBJ_TYPE_CODE = PERSISTABLE_OBJ_TYPE_BASE_CODE + 20;
	
	public final static long LOCATION_OBJ_TYPE_CODE = PERSISTABLE_OBJ_TYPE_BASE_CODE + 30;
}
