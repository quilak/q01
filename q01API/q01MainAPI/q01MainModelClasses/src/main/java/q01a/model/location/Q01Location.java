package q01a.model.location;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import q01a.common.model.Q01PersistableObjectBase;
import q01a.model.oids.Q01MainOIDs.Q01LocationOID;
import r01f.objectstreamer.annotations.MarshallField;
import r01f.objectstreamer.annotations.MarshallType;
import r01f.types.geo.GeoPosition;

@MarshallType(as="location")
@Accessors(prefix="_")
public class Q01Location
     extends Q01PersistableObjectBase<Q01LocationOID,Q01Location> {
	private static final long serialVersionUID = -6325823549685836079L;

///////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////
	@MarshallField(as="position")
	@Getter @Setter private GeoPosition _position;
}
