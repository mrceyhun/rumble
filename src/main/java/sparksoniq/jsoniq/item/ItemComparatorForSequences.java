package sparksoniq.jsoniq.item;

import sparksoniq.exceptions.SparksoniqRuntimeException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;

public class ItemComparatorForSequences implements Comparator<Item>, Serializable {
    /**
     * Comparator used for sequence aggregate functions and their  RDD evaluations
     * It compares 2 atomic items (non-null)
     * Non-atomics and nulls throw an exception
     * @return -1 if v1 < v2; 0 if v1 == v2; 1 if v1 > v2;
     */
    public int compare(Item v1, Item v2) {
        int result;
        if (Item.isNumeric(v1) && Item.isNumeric(v2)) {
            BigDecimal value1 = Item.getNumericValue(v1, BigDecimal.class);
            BigDecimal value2 = Item.getNumericValue(v2, BigDecimal.class);
            result = value1.compareTo(value2);
        } else if (v1.isBoolean() && v2.isBoolean()) {
            Boolean value1 = new Boolean(v1.getBooleanValue());
            Boolean value2 = new Boolean(v2.getBooleanValue());
            result = value1.compareTo(value2);
        } else if (v1.isString()&& v2.isString()) {
            String value1 = v1.getStringValue();
            String value2 = v2.getStringValue();
            result = value1.compareTo(value2);
        } else {
            throw new SparksoniqRuntimeException(v1.serialize() + " " + v2.serialize());
        }
        return result;
    }
}
