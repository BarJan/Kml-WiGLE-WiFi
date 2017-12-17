package Algos;

import java.util.ArrayList;

import Data_classes.*;

public class Alg2 {
	private final int power=2,norm=10000,minSig=3,noSig=-120,noSigDiff=100;
	private final double sigDiff=0.4;
	private double pi;
	private ArrayList<Double> Pis;


	public void calcPos(Samples empty, Samples full) {
		// ���� ���� ���� ������ ���� ���� ���� �� ����� ��� ��� ���� ����.
		// ���� ����� ������ �� "�� 3 �����" ����� ���.
		// ������ ��� ������ �� ����� "����" ����� ����� �� 3������ ���.
		//������ ���� ���� ������ ���� ���� ������ ��� ����� ���� ������� �� �� ������ ���� ����� �� ������ ����.

		for(int i =0;i<empty.length();i++) {
			for(int j=0;j<full.length();j++) {
				// ��� ���� ����� ������ �� ����� �� �� ����� ���
				//����� ��� ������ �� ������� ���� ����� ������ ������ ������� ����, ���� ���� �� ������ ���������.
				// ���� ���� ����� �� ����� �� ���

				if(empty.getSample(i).getMac().contains((CharSequence) full.getSample(j))) {
					Pis.add(wCalc(Integer.parseInt(empty.getSample(i).getMacSig()), Integer.parseInt(full.getSample(j).getMacSig())));
				}
			}

		}


	}

	private double wCalc(int sig1,int sig2 ) {

		int diff=((sig2==noSig)? noSigDiff : Math.max((sig1-sig2), minSig));
		double w = norm/((Math.pow(diff, sigDiff))*(Math.pow(sig2, 2)));
		return w;
	}


}
