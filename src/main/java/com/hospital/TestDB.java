package com.hospital;

import java.sql.Connection;

import com.hospital.utils.DBConnection;

public class TestDB {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("✅ Connected to MySQL!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

