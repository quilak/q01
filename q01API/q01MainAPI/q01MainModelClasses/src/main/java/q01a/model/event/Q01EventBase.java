package q01a.model.event;

import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import q01a.common.model.Q01PersistableObjectBase;
import q01a.model.oids.Q01MainOIDs.Q01EventOID;
import q01a.model.oids.Q01MainOIDs.Q01LocationOID;
import q01a.model.participant.Q01EventParticipant;
import q01a.model.sport.Q01Sport;
import r01f.aspects.interfaces.dirtytrack.ConvertToDirtyStateTrackable;
import r01f.objectstreamer.annotations.MarshallField;
import r01f.objectstreamer.annotations.MarshallField.DateFormat;
import r01f.objectstreamer.annotations.MarshallField.MarshallDateFormat;
import r01f.objectstreamer.annotations.MarshallField.MarshallFieldAsXml;

@ConvertToDirtyStateTrackable
@Accessors(prefix="_")
public abstract class Q01EventBase<SELF_TYPE extends Q01EventBase<SELF_TYPE>>
	 		  extends Q01PersistableObjectBase<Q01EventOID,SELF_TYPE>
		   implements Q01Event {

	private static final long serialVersionUID = 6036873778203336219L;
///////////////////////////////////////////////////////////////////////////////
// 	FIELDS
///////////////////////////////////////////////////////////////////////////////
	@MarshallField(as="sport")
	@Getter @Setter private Q01Sport _sport;

	@MarshallField(as="startDate",dateFormat=@MarshallDateFormat(use=DateFormat.ISO8601))
	@Getter @Setter private Date _startDate;

	@MarshallField(as="endDate",dateFormat=@MarshallDateFormat(use=DateFormat.ISO8601))
	@Getter @Setter private Date _endDate;

	@MarshallField(as="participants",
				   whenXml=@MarshallFieldAsXml(collectionElementName="participan"))
	@Getter @Setter private Set<Q01EventParticipant> _participants;

	@MarshallField(as="locationOid",
				   whenXml=@MarshallFieldAsXml(attr=true))
	@Getter @Setter private Q01LocationOID _locationOid;
///////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////
}
