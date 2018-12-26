package me.itzg.tryspqr.model;

import java.util.Date;
import lombok.Data;

/**
 * @author Geoff Bourne
 * @since Dec 2018
 */
@Data
public class Entry {
  String owner;
  String id;
  Date when;
}
