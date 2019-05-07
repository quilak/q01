package q01f.common.model;



import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import q01f.common.model.oids.Q01CommonOIDs.Q01ModelObjectOID;
import r01f.aspects.interfaces.dirtytrack.ConvertToDirtyStateTrackable;
import r01f.locale.LanguageTexts;
import r01f.model.PersistableModelObjectBase;
import r01f.objectstreamer.annotations.MarshallField;
import r01f.validation.ObjectValidationResult;
import r01f.validation.ObjectValidationResultBuilder;
import r01f.validation.Validates;

@ConvertToDirtyStateTrackable
@Accessors(prefix="_")
public abstract class Q01PersistableModelObjectBase<O extends Q01ModelObjectOID,
					   				 		 		SELF_TYPE extends Q01PersistableModelObjectBase<O,SELF_TYPE>>
	          extends PersistableModelObjectBase<O,SELF_TYPE>
           implements Q01PersistableModelObject<O>,
	   		   		  Validates<SELF_TYPE> {

	private static final long serialVersionUID = -3660434432751867084L;
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	@MarshallField(as="name")
	@Getter @Setter protected LanguageTexts _name;

	@MarshallField(as="description")
	@Getter @Setter protected LanguageTexts _description;
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01PersistableModelObjectBase() {
		// constructor
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  VALIDATION
/////////////////////////////////////////////////////////////////////////////////////////
	@Override @SuppressWarnings("unchecked")
	public <M extends Q01PersistableModelObject<?>> Validates<M> asValidates() {
		return (Validates<M>)this;
	}
	@Override @SuppressWarnings("unchecked")
	public ObjectValidationResult<SELF_TYPE> validate(final SELF_TYPE obj) {
		// Validate the data
		if (this.getOid() == null) {
			return ObjectValidationResultBuilder.on((SELF_TYPE)this)
												.isNotValidBecause("The {} object MUST have an oid",
													  			   this.getClass().getSimpleName());
		}
		if (this.getName() == null || !this.getName().isTextDefinedForAnyLanguage()) return ObjectValidationResultBuilder.on((SELF_TYPE)this)
																			   					.isNotValidBecause("The {} object with oid={} has a NULL NAME or the NAME length is too short",
																			   									   this.getClass().getSimpleName(),this.getOid());

		return ObjectValidationResultBuilder.on((SELF_TYPE)this)
											.isValid();
	}
}
