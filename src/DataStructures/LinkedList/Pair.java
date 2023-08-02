package DataStructures.LinkedList;

import java.util.Collection;

public class Pair<Type> {

    private Type Element1;
    private Type Element2;

    public Pair(Type element1, Type element2) {
        Element1 = element1;
        Element2 = element2;
    }

    public boolean Compare(Type Element1,Type Element2){
        if(this.Element1 == Element1 && this.Element2 == Element2){
            return true;
        }else{
            return false;
        }
    }

    public boolean Compare(Pair that){
        if(this.Element1 == that.Element1 && this.Element2 == that.Element2){
            return true;
        }else{
            return false;
        }
    }

    public boolean Compare(Pair that,boolean isOrdered){
        if(isOrdered) {
            if (this.Element1 == that.Element1 && this.Element2 == that.Element2) {
                return true;
            } else {
                return false;
            }
        }else{
            if(this.Element1 == that.Element1 || this.Element2 == that.Element2 || this.Element1 == that.Element2 || this.Element2 == that.Element1){
                return true;
            }else{
                return false;
            }
        }
    }
    public boolean DoesNotContainDuplicateIn(Collection<Pair> collection){
        boolean isFound = false;
        for(Pair PairInCollection:collection){
            if(PairInCollection.Compare(this.Element1,this.Element2)){
                isFound = true;
            }
        }
        return !isFound;
    }

    public boolean DoesNotContainDuplicateOrFlippedDuplicatedIn(Collection<Pair> collection){
        boolean isFound = false;
        for(Pair PairInCollection:collection){
            if(PairInCollection.Compare(this.Element1,this.Element2) || PairInCollection.Compare(this.Element2,this.Element1)){
                isFound = true;
            }
        }
        return !isFound;
    }



    @Override
    public String toString() {
        return "(Pair contains: "+Element1.toString()+","+Element2.toString()+")";
    }

    public Type getElement1() {
        return Element1;
    }

    public void setElement1(Type element1) {
        Element1 = element1;
    }

    public Type getElement2() {
        return Element2;
    }

    public void setElement2(Type element2) {
        Element2 = element2;
    }
}
