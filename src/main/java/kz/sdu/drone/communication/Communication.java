package kz.sdu.drone.communication;
import kz.sdu.drone.product.FamilyProduct;
public interface Communication extends FamilyProduct { String transmit(String message); }
