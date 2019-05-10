package q01a.common.validators;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import q01a.common.model.Q01PersistableObjectBase;
import r01f.validation.ObjectValidationResult;
import r01f.validation.ObjectValidationResultBuilder;
import r01f.validation.Validates;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public abstract class Q01CommonValidators {
/////////////////////////////////////////////////////////////////////////////////////////
//  BASE
/////////////////////////////////////////////////////////////////////////////////////////
	public static <P extends Q01PersistableObjectBase<?,P>> Validates<P> createBaseValidator() {
		return new Validates<P>() {
						@Override
						public ObjectValidationResult<P> validate(final P obj) {
							// Validate the data
							if (obj.getOid() == null) {
								return ObjectValidationResultBuilder.on(obj)
																	.isNotValidBecause("The {} object MUST have an oid",
																		  			   obj.getClass().getSimpleName());
							}
							if (obj.getName() == null || !obj.getName().isTextDefinedForAnyLanguage()) return ObjectValidationResultBuilder.on(obj)
																								   					.isNotValidBecause("The {} object with oid={} has a NULL NAME or the NAME length is too short",
																								   									   obj.getClass().getSimpleName(),obj.getOid()); 
							
							return ObjectValidationResultBuilder.on(obj)
																.isValid();
						}
			   };
	}

}
