package q01a.common.model;



import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import q01a.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOID;
import q01a.common.validators.Q01CommonValidators;
import r01f.aspects.interfaces.dirtytrack.ConvertToDirtyStateTrackable;
import r01f.locale.LanguageTexts;
import r01f.model.PersistableModelObjectBase;
import r01f.objectstreamer.annotations.MarshallField;
import r01f.validation.ObjectValidationResult;
import r01f.validation.SelfValidates;
import r01f.validation.Validates;

@ConvertToDirtyStateTrackable
@Accessors(prefix="_")
public abstract class Q01PersistableObjectBase<O extends Q01PersistableObjectOID,
					   				 		   SELF_TYPE extends Q01PersistableObjectBase<O,SELF_TYPE>>
	          extends PersistableModelObjectBase<O,SELF_TYPE>
           implements Q01PersistableObject<O>,
	   		   		  SelfValidates<SELF_TYPE> {

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
	public Q01PersistableObjectBase() {
		// constructor
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  VALIDATION
/////////////////////////////////////////////////////////////////////////////////////////
	@Override @SuppressWarnings("unchecked")
	public <M extends Q01PersistableObject<?>> Validates<M> asValidates() {
		return (Validates<M>)this;
	}
	@Override @SuppressWarnings("unchecked")
	public ObjectValidationResult<SELF_TYPE> validate() {
		return Q01CommonValidators.<SELF_TYPE>createBaseValidator()
								  .validate((SELF_TYPE)this);
	}
}
