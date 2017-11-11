package sort;

import java.io.*;
import java.util.StringTokenizer;

/**
 * on 31/12/2016.
 */

class Bucket {
    int data;
    Bucket node;

    public Boolean isEmpty() {
        if (this.node == null) {
            return true;
        }
        return false;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Bucket getNode() {
        return node;
    }

    public void setNode(Bucket node) {
        this.node = node;
    }

    Bucket(int data) {
        this.data = data;
    }

    Bucket(Bucket node) {
        this.node = node;
    }
}

public class RadixSort {

    Bucket[] bucketArr = new Bucket[10];
    Bucket[] data;

    void inputNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        System.out.println("숫자 갯수를 입력하세요:");
        int n = Integer.parseInt(st.nextToken());//숫자 갯수 입력
//        int n = 4;
        data = new Bucket[n];//숫자 저장소
//        data[0] = new Bucket(231);
//        data[1] = new Bucket(152);
//        data[2] = new Bucket(675);
//        data[3] = new Bucket(442);

        System.out.println("숫자를 입력하세요:");

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            data[i] = new Bucket(Integer.parseInt(st.nextToken()));
        }

    }

    void sort() throws IOException {
        inputNumber();
        // display();


        Boolean keepGoing = true;
        int cnt = 1;
        int bucketNum = 0;
        int index = 0;
        while (keepGoing) {
            keepGoing = false;

            for (int i = 0; i < data.length; i++) {
                //Bucket에 Data 넣기
                int num = data[i].getData();
                for (int k = 0; k < cnt; k++) {
                    //자릿수
                    bucketNum = num % 10;
                    num /= 10;
                }
                if (bucketNum != 0) {
                    keepGoing = true;
                }
                //Number number = new Number(data[i].getNum());
                if (bucketArr[bucketNum] == null) {
                    bucketArr[bucketNum] = data[i];
                } else {

                    Bucket temp = data[i];
                    Bucket head = bucketArr[bucketNum];
                    while (head.node != null) {
                        head = head.node;
                    }
                    head.node = temp;
                }
            }
            //Bucket에 순서대로 빼기
            index = 0;
            for (int i = 0; i < bucketArr.length; i++) {
                if (bucketArr[i] != null) {
                    Bucket temp = bucketArr[i];
                    do {
                        data[index] = temp;
                        temp = temp.node;
                        data[index++].node = null;//data[]에 들어가면 링크 삭제
                    } while (temp != null);
                }
            }
            bucketInit();
            cnt++;
        }
        display();

    }

    void bucketInit() {
        //bucketArr 초기화
        for (int i = 0; i < bucketArr.length; i++) {
            bucketArr[i] = null;
        }

    }

    void display() throws IOException {

//        for (int i = 0; i < data.length; i++) {
//            System.out.print(data[i].getData() + " ");
//        }
//        System.out.println();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < data.length; i++) {
            bw.write(String.valueOf(data[i].getData()) + "\n");
        }
        bw.close();

    }


    public static void main(String[] args) throws IOException {
        new RadixSort().sort();
    }
}