package com.vmieres.msrepairlist.services;

import org.springframework.stereotype.Service;

@Service
public class AuxService {

    public int getIndex(int repairs) {
        if (repairs >= 1 && repairs <= 2) {
            return 0;
        } else if (repairs >= 3 && repairs <= 5) {
            return 1;
        } else if (repairs >= 6 && repairs <= 9) {
            return 2;
        } else
            return 3;
    }

    public int getIndex2(int km) {
        if (km >= 0 && km <= 5000) {
            return 0;
        } else if (km >= 5001 && km <= 12000) {
            return 1;
        } else if (km >= 12001 && km <= 25000) {
            return 2;
        } else if (km >= 25001 &&  km <= 40000) {
            return 3;
        } else 
            return 4;
    }

    public int getIndex3(int age) {
        if (age >= 0 && age <= 5) {
            return 0;
        } else if (age >= 6 && age <= 10) {
            return 1;
        } else if (age >= 11 && age <= 15) {
            return 2;
        } else 
            return 3;
    }

}
