package com.iu.transfer;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s4.TestAbstractCase;
import com.iu.s4.transfer.Work;

public class WorkTest extends TestAbstractCase{
	
	@Inject
	private Work work;
	
	@Test
	public void test() {
		work.goWork();
	}

}
