package server.RMIservice;



import java.net.MalformedURLException;

import java.rmi.AlreadyBoundException;

import java.rmi.Naming;

import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;



public class RemoteHelper {

    public RemoteHelper(){

        initServer();

    }



    private void initServer(){

        DataRemoteObject dataRemoteObject;

        try {

            dataRemoteObject = new DataRemoteObject();

            LocateRegistry.createRegistry(8886);

            Naming.bind("rmi://127.0.0.1:8886/DataRemoteObject", dataRemoteObject);

        } catch (RemoteException | MalformedURLException | AlreadyBoundException e) {

            e.printStackTrace();

        }


    }

}