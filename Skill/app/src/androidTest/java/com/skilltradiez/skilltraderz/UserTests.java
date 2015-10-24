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

import static org.junit.Assert.*;

public class UserTests {
    public void testGetProfile() {
        UserDatabase db = new UserDatabase();
        User user = db.createUser("Username", "Profile");
        assertNotNull(user.getProfile());
    }

    public void testGetInventory() {
        UserDatabase db = new UserDatabase();
        User user = db.createUser("Username", "Profile");
        assertNotNull(user.getInventory());
    }

    public void testGetFriendsList() {
        UserDatabase db = new UserDatabase();
        User user = db.createUser("Username", "Profile");
        assertNotNull(user.getFriendsList());
    }
}