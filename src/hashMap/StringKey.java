package hashMap;

public class StringKey<K> implements Comparable<StringKey> {
    private String keyName;


    public StringKey(String keyName) {
        this.keyName = keyName;
    }

 
    public String getKeyName() {
        return this.keyName;
    }


    public int compareTo(StringKey other) {
        return this.keyName.compareTo(other.keyName);
    }


    public int hashCode() {
        int hashCode = 0;
        int asciiValue;
        int termValue;
        final int COEFFICIENT = 31;


        for (int i = 0; i < this.keyName.length(); i++) {
            asciiValue = (int)keyName.charAt(i);
            termValue = asciiValue * (int)Math.pow(COEFFICIENT, i);
            hashCode += termValue;
        }

        return Math.abs(hashCode);
    }


    public boolean equals(Object obj) {

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        StringKey stringKey = (StringKey) obj;

        if (this.keyName.equals(stringKey.keyName)) {
            return true;
        }
        else {
            return false;
        }
    }


    public String toString() {
        return "KeyName: " + keyName + " HashCode: " + hashCode();
    }
}
