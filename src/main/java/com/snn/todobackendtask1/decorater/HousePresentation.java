package com.snn.todobackendtask1.decorater;

public class HousePresentation {
    public static void main(String[] args) {

        House flatHouse = new FlatHouse();
        House dublexHouse = new DublexHouse();

        House twoRoomsFlatHouse = new TwoRooms(flatHouse);
        twoRoomsFlatHouse.build();
        House twoRoomsDublexHouse = new ManyRooms(dublexHouse);
        twoRoomsDublexHouse.build();
        House manyRoomsFlatHouse = new ManyRooms(flatHouse);
        manyRoomsFlatHouse.build();
        House manyRoomsDublexHouse = new ManyRooms(new DublexHouse());
        manyRoomsDublexHouse.build();
    }
}
interface House{
     void build();
}

class FlatHouse implements House{

    @Override
    public void build() {
        System.out.println("Flat house build");
    }
}

class DublexHouse implements House{

    @Override
    public void build() {
        System.out.println("Dublex house build");
    }
}

abstract class HouseDecoreter implements House{

   protected House decoretedhouse;

    public HouseDecoreter(House decoretedhouse) {
        this.decoretedhouse = decoretedhouse;
    }

    @Override
    public void build() {
        decoretedhouse.build();
    }

}

class TwoRooms extends HouseDecoreter{

    public TwoRooms(House decoretedhouse) {
        super(decoretedhouse);
    }
    @Override
    public void build() {
        decoretedhouse.build();
        createTwoRooms();
    }
    void createTwoRooms(){
        System.out.print("Create two rooms");
    }

}

class ManyRooms extends HouseDecoreter{


    public ManyRooms(House decoretedhouse) {
        super(decoretedhouse);
    }

    @Override
    public void build() {
        decoretedhouse.build();
        createManyRooms();
    }

    void createManyRooms(){
        System.out.println("Create Many Rooms");
    }

}