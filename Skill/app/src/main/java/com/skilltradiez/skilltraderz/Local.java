package com.skilltradiez.skilltraderz;
/*
 *    Team15Alpha
 *    AppName: SkillTradiez (Subject to change)
 *    Copyright (C) 2015  Stephen Andersen, Falon Scheers, Elyse Hill, Noah Weninger, Cole Evans
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



/**
 * Created by Falon3 on 2015-11-04.
 */
public class Local {
    LocalPersistentObject save_object;
    private static final String SAVE_FILE = "save_file.sav";


    // method to save LocalPersistentObject to local file
    public void saveToFile() throws IOException {

        FileOutputStream fop = null;
        File file = new File(SAVE_FILE);

        // create file if doesn't exist
        if (!file.exists()) {
            file.createNewFile();
        }
        fop = new FileOutputStream(file);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(fop));
        Gson gson = new Gson();
        gson.toJson(save_object, output);
        output.flush();
        fop.close();


    }
    // method to read LocalPersistentObject from local file
    // returns what is read as a LocalPersistentObject
    public LocalPersistentObject readFromFile() throws IOException {

        FileInputStream fip = null;
        File file = new File(SAVE_FILE);

        // create file if doesn't exist
        if (!file.exists()) {
            file.createNewFile();
            save_object = new LocalPersistentObject();
        }
        fip = new FileInputStream(file);
        BufferedReader in = new BufferedReader(new InputStreamReader(fip));
        Gson gson = new Gson();

        return gson.fromJson(in, LocalPersistentObject.class);


    }




}