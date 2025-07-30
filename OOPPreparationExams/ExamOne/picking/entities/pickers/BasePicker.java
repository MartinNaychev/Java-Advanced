package OOPPreparationExams.ExamOne.picking.entities.pickers;

import picking.entities.bag.Bag;
import picking.entities.bag.BagImpl;

import static picking.common.ExceptionMessages.PICKER_NAME_NULL_OR_EMPTY;
import static picking.common.ExceptionMessages.PICKER_VITALITY_LESS_THAN_ZERO;

public abstract class BasePicker implements Picker{

    private String name;
    private int vitality;
    private Bag bag;

    public BasePicker(String name, int vitality) {
       setName(name);
        setVitality(vitality);
        this.bag = new BagImpl();
    }

    public void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException(PICKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setVitality(int vitality) {
        if (vitality<0){
            throw new IllegalArgumentException(PICKER_VITALITY_LESS_THAN_ZERO);
        }
        this.vitality = vitality;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getVitality() {
        return this.vitality;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void pick() {
       int newVitality = getVitality()-10;
       if (newVitality<0){
           newVitality=0;
       }
       setVitality(newVitality);
    }
}
