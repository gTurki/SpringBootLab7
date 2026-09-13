package com.example.springbootlab7.Service;

import com.example.springbootlab7.Model.Classroom;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClassroomService {

    private final ArrayList<Classroom> classrooms = new ArrayList<>();

    public ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
    }

    public boolean updateClassroom(String id, Classroom classroom) {
        for (int i = 0; i < classrooms.size(); i++) {
            if (classrooms.get(i).getId().equalsIgnoreCase(id)) {
                classrooms.set(i, classroom);
                return true;
            }
        }
        return false;
    }

    public boolean deleteClassroom(String id) {
        for (int i = 0; i < classrooms.size(); i++) {
            if (classrooms.get(i).getId().equalsIgnoreCase(id)) {
                classrooms.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Classroom> getAllRoomsInFloor(int floorNumber) {
        ArrayList<Classroom> temp = new ArrayList<>();

        for (Classroom c : classrooms) {
            if (c.getFloorNumber() == floorNumber) {
                temp.add(c);
            }
        }
        return temp;
    }

    public boolean changeRoomCapacity(String id, int capacity) {
        if (capacity <= 0)
            return false;

        for (Classroom c : classrooms) {
            if (c.getId().equalsIgnoreCase(id)) {
                c.setCapacity(capacity);
                return true;
            }
        }
        return false;
    }
}
