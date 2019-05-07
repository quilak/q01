package q01f.common.internal;

import r01f.services.ids.ServiceIDs.ClientApiAppCode;
import r01f.services.ids.ServiceIDs.CoreAppCode;
import r01f.services.ids.ServiceIDs.CoreModule;

public abstract class Q01AppCodes {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTANTS
/////////////////////////////////////////////////////////////////////////////////////////
	private static final String APP_CODE_STR = "q01";
	
	public static final String API_APPCODE_STR = APP_CODE_STR + "a";
	public static final String CORE_APPCODE_STR = APP_CODE_STR + "c";
	public static final String WEB_FRONT_END_APPCODE_STR = APP_CODE_STR + "ui";
	
	public static final String MAIN_MODULE_STR = "main";	
	public static final String MAIN_APP_AND_MOD_STR = CORE_APPCODE_STR + "." + MAIN_MODULE_STR;
	
	public static final ClientApiAppCode API_APPCODE = ClientApiAppCode.forId(Q01AppCodes.API_APPCODE_STR);
	public static final CoreAppCode CORE_APPCODE = CoreAppCode.forId(Q01AppCodes.CORE_APPCODE_STR);
	public static final CoreAppCode WEB_FRONT_END_APPCODE = CoreAppCode.forId(Q01AppCodes.WEB_FRONT_END_APPCODE_STR);
	
	public static final CoreModule MAIN_CORE_MOD = CoreModule.forId(MAIN_MODULE_STR);
}