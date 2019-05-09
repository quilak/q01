package q01a.model.sport;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import r01f.enums.EnumWithCode;
import r01f.enums.EnumWithCodeWrapper;

@Accessors(prefix="_")
@RequiredArgsConstructor
public enum Q01FootballPosition
 implements EnumWithCode<String,Q01FootballPosition>,
 			Q01SportTeamPosition {
	GOALKEEPER		("goalkeeper"),
	DEFENDER  		("defender"),
	MIDDLEFIELDER	("middlefielder"),
	FORWARD  		("forward");
///////////////////////////////////////////////////////////////////////////////
// 	
///////////////////////////////////////////////////////////////////////////////
	@Getter private final Class<String> _codeType = String.class;
	@Getter private final String _code;
///////////////////////////////////////////////////////////////////////////////
// 	
///////////////////////////////////////////////////////////////////////////////
	private static final EnumWithCodeWrapper<String,Q01FootballPosition> WRAPPER = EnumWithCodeWrapper.wrapEnumWithCode(Q01FootballPosition.class);
	
	@Override
	public boolean isIn(final Q01FootballPosition... els) {
		return WRAPPER.isIn(this,els);
	}
	@Override
	public boolean is(final Q01FootballPosition el) {
		return WRAPPER.is(this,el);
	}
	public static boolean canBe(final String name) {
		return WRAPPER.canBe(name);
	}
	public static boolean canBeFromCode(final String code) {
		return WRAPPER.canBeFromCode(code);
	}
}
