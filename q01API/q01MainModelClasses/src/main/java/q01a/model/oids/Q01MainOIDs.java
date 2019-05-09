package q01a.model.oids;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import q01f.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOIDBase;
import r01f.annotations.Immutable;
import r01f.objectstreamer.annotations.MarshallType;

@RequiredArgsConstructor(access=AccessLevel.PRIVATE)
public abstract class Q01MainOIDs {
/////////////////////////////////////////////////////////////////////////////////////////
//  SPORT
/////////////////////////////////////////////////////////////////////////////////////////
	@Immutable
	@MarshallType(as="sportOid")
	@Accessors(prefix="_")
	@NoArgsConstructor
	public static final class Q01SportOID
	      		      extends Q01PersistableObjectOIDBase {

		private static final long serialVersionUID = 4600399779018051672L;

		public Q01SportOID(final String id) {
			super(id);
		}
		public static Q01SportOID valueOf(final String s) {
			return Q01SportOID.forId(s);
		}
		public static Q01SportOID fromString(final String s) {
			return Q01SportOID.forId(s);
		}
		public static Q01SportOID forId(final String id) {
			return new Q01SportOID(id);
		}
		public static Q01SportOID supply() {
			return Q01SportOID.forId(Q01PersistableObjectOIDBase.supplyId());
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  EVENT
/////////////////////////////////////////////////////////////////////////////////////////
	@Immutable
	@MarshallType(as="eventOid")
	@Accessors(prefix="_")
	@NoArgsConstructor
	public static final class Q01EventOID
	      		      extends Q01PersistableObjectOIDBase {
		private static final long serialVersionUID = 2566200452645406300L;

		public Q01EventOID(final String id) {
			super(id);
		}
		public static Q01EventOID valueOf(final String s) {
			return Q01EventOID.forId(s);
		}
		public static Q01EventOID fromString(final String s) {
			return Q01EventOID.forId(s);
		}
		public static Q01EventOID forId(final String id) {
			return new Q01EventOID(id);
		}
		public static Q01EventOID supply() {
			return Q01EventOID.forId(Q01PersistableObjectOIDBase.supplyId());
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  LOCATION
/////////////////////////////////////////////////////////////////////////////////////////
	@Immutable
	@MarshallType(as="locationOid")
	@Accessors(prefix="_")
	@NoArgsConstructor
	public static final class Q01LocationOID
	      		      extends Q01PersistableObjectOIDBase {
		private static final long serialVersionUID = -1524287019888055009L;

		public Q01LocationOID(final String id) {
			super(id);
		}
		public static Q01LocationOID valueOf(final String s) {
			return Q01LocationOID.forId(s);
		}
		public static Q01LocationOID fromString(final String s) {
			return Q01LocationOID.forId(s);
		}
		public static Q01LocationOID forId(final String id) {
			return new Q01LocationOID(id);
		}
		public static Q01LocationOID supply() {
			return Q01LocationOID.forId(Q01PersistableObjectOIDBase.supplyId());
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  PERSON
/////////////////////////////////////////////////////////////////////////////////////////
	@Immutable
	@MarshallType(as="personOid")
	@Accessors(prefix="_")
	@NoArgsConstructor
	public static final class Q01PersonOID
	      		      extends Q01PersistableObjectOIDBase {
		private static final long serialVersionUID = 291576728107645212L;

		public Q01PersonOID(final String id) {
			super(id);
		}
		public static Q01PersonOID valueOf(final String s) {
			return Q01PersonOID.forId(s);
		}
		public static Q01PersonOID fromString(final String s) {
			return Q01PersonOID.forId(s);
		}
		public static Q01PersonOID forId(final String id) {
			return new Q01PersonOID(id);
		}
		public static Q01PersonOID supply() {
			return Q01PersonOID.forId(Q01PersistableObjectOIDBase.supplyId());
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  TEAM
/////////////////////////////////////////////////////////////////////////////////////////
	@Immutable
	@MarshallType(as="teamOid")
	@Accessors(prefix="_")
	@NoArgsConstructor
	public static final class Q01TeamOID
	      		      extends Q01PersistableObjectOIDBase {
		private static final long serialVersionUID = 6526617936411056474L;

		public Q01TeamOID(final String id) {
			super(id);
		}
		public static Q01TeamOID valueOf(final String s) {
			return Q01TeamOID.forId(s);
		}
		public static Q01TeamOID fromString(final String s) {
			return Q01TeamOID.forId(s);
		}
		public static Q01TeamOID forId(final String id) {
			return new Q01TeamOID(id);
		}
		public static Q01TeamOID supply() {
			return Q01TeamOID.forId(Q01PersistableObjectOIDBase.supplyId());
		}
	}
}
