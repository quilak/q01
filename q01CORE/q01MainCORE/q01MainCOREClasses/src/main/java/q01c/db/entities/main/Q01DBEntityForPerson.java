package q01c.db.entities.main;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.MultitenantType;

import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import q01c.db.entities.Q01DBEntityBase;
import r01f.persistence.db.entities.primarykeys.DBPrimaryKeyForModelObjectImpl;


@Entity @Cacheable(false)
@Multitenant(MultitenantType.SINGLE_TABLE)
@Table(name="Q01PERSON")
	@IdClass(DBPrimaryKeyForModelObjectImpl.class)

@NamedQueries({

})

@Accessors(prefix="_")
@NoArgsConstructor
public class Q01DBEntityForPerson
     extends Q01DBEntityBase {
	
	private static final long serialVersionUID = 359898758598307851L;

}
