// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package ler.robot.subsystems;

/** OPEN and CLOSED are obvious,  PARTIAL is when the gate is between open and closed.
 *  BAD state is when both open and closed is True which should be impossible. Probably
 *  the limit switches are hooked up incorrectly.
 */
public enum GateState { CLOSED, OPEN, PARTIAL, BAD}
