package org.rumbledb.types;

import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.rumbledb.context.Name;

import java.util.Set;

/**
 * Class representing the generic 'item' item type
 */
public class ItemItemType implements ItemType {

    private static final long serialVersionUID = 1L;

    static final ItemType item = new ItemItemType(Name.createVariableInDefaultTypeNamespace("item"));
    private Name name;

    public ItemItemType() {
    }

    private ItemItemType(Name name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ItemType)) {
            return false;
        }
        return this.getIdentifierString().equals(((ItemType) o).getIdentifierString());
    }

    @Override
    public boolean hasName() {
        return true;
    }

    @Override
    public Name getName() {
        return this.name;
    }

    @Override
    public boolean isSubtypeOf(ItemType superType) {
        return superType.equals(item);
    }

    @Override
    public ItemType findLeastCommonSuperTypeWith(ItemType other) {
        return item;
    }

    @Override
    public int getTypeTreeDepth() {
        return 0;
    }

    @Override
    public ItemType getBaseType() {
        return null;
    }

    @Override
    public Set<FacetTypes> getAllowedFacets() {
        throw new UnsupportedOperationException("item type does not support facets");
    }

    @Override
    public String toString() {
        return this.name.toString();
    }

    @Override
    public DataType toDataFrameType() {
        return DataTypes.BinaryType;
    }

    @Override
    public boolean isDataFrameType() {
        return false;
    }
}
