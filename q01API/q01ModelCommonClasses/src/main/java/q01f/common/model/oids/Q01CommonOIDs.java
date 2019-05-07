package q01f.common.model.oids;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import r01f.annotations.Immutable;
import r01f.guids.OIDBaseMutable;
import r01f.guids.OIDTyped;
import r01f.guids.PersistableObjectOID;
import r01f.guids.SuppliesOID;

@RequiredArgsConstructor(access=AccessLevel.PRIVATE)
public abstract class Q01CommonOIDs {
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
	public static interface Q01ModelObjectOID
					extends OIDTyped<String>,
							PersistableObjectOID,
							SuppliesOID {
		// just a marker interface
	}
	@Immutable
	@Accessors(prefix="_")
	public static abstract class Q01ModelObjectOIDBase
	              		 extends OIDBaseMutable<String> 	// normally this should extend OIDBaseInmutable BUT it MUST have a default no-args constructor to be serializable
					  implements Q01ModelObjectOID {
		private static final long serialVersionUID = 7172918999884430100L;
		
		public Q01ModelObjectOIDBase() {
			// no args constructor
		}
		public Q01ModelObjectOIDBase(final String id) {
			super(id);
		}
		/**
		 * Generates an oid
		 * @return the generated oid
		 */
		protected static String supplyId() {
			return UUID.randomUUID().toString();
		}
	}
}
