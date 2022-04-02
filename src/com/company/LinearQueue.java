package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LinearQueue {

    private int front, rear;
    private String[] nums;

    public LinearQueue(int size) {
        this.front = this.rear = -1;
        this.nums = new String[size];
    }

    public void print(){
            for (int i = front; i < nums.length ; i++) {
                if (nums[i] != null) {
                    System.out.print(nums[i] + " - ");
                } else {
                    System.out.print("SELESAIKAN!");
                    System.out.println();
                    break;
            }
        }
    }

    public void printall() {
        System.out.println("Daftar Tugas!");
        for (int i = front; i < nums.length ; i++) {
            if (nums[i] != null) {
                System.out.println(nums[i]);
            } else {
                break;
            }
        }
    }

    public void enqueue (String data) {
        if (isFull()) throw new IllegalStateException();
        if (isEmpty()) front++;
        nums[++rear] = data;
    }

    public String dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        String temp = nums[front];
        if (front == rear) front = rear = -1;
        else front ++;
        return temp;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == nums.length-1;
    }

    public static void main(String[] args) {
        LinearQueue q = new LinearQueue(10);

        int loopX = 0;
        int choosenMenu = 0;
        while(loopX == 0) {
            System.out.println("\nTo-Do List!");
            System.out.println("Menu: ");
            System.out.println("1. Tambah List");
            System.out.println("2. Pekerjaan yang harus diselesaikan");
            System.out.println("3. Pekerjaan Selesai");
            System.out.println("4. Tampilkan To-Do List");
            System.out.println("5. Keluar dari Program");
            System.out.print("Pilihan Menu (1 - 5) >>> ");
            Scanner inputUser = new Scanner(System.in);
            int pilihan = inputUser.nextInt();

            switch(pilihan) {
                case 1:
                    String tambah = inputUser.next();
                    q.enqueue(tambah);
                    break;
                case 2:
                    q.print();
                    break;
                case 3:
                    q.dequeue();
                    break;
                case 4:
                    q.printall();
                    break;
                case 5:
                    loopX++;
                    break;
            }
        }
    }
}
