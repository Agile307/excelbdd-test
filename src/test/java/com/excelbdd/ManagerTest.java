package com.excelbdd;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.jupiter.api.Test;



class ManagerTest {


	private Manager mockedManager = mock(Manager.class);

	private List<Integer> mockList = mock(List.class);

	@Test
	final void testManager() {
		// stubbing appears before the actual execution
		when(mockedManager.addA(1)).thenReturn(100);
		assertEquals(100, mockedManager.addA(1));
	}

	@Test
	public void shorthand() {
		mockList.add(1);
		verify(mockList).add(1);
	}

	@Test
	public void verifying_number_of_invocations() {
		List<Integer> list = mock(List.class);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		// 验证是否被调用一次，等效于下面的times(1)
		verify(list).add(1);
		verify(list, times(1)).add(1);
		// 验证是否被调用2次
		verify(list, times(2)).add(2);
		// 验证是否被调用3次
		verify(list, times(3)).add(3);
		// 验证是否从未被调用过
		verify(list, never()).add(4);
		// 验证至少调用一次
		verify(list, atLeastOnce()).add(1);
		// 验证至少调用2次
		verify(list, atLeast(2)).add(2);
		// 验证至多调用3次
		verify(list, atMost(3)).add(3);
	}

	@Test
	public void doThrow_when() {
		List<Integer> list = mock(List.class);
		doThrow(new RuntimeException()).when(list).add(1);
		
		assertThrows(RuntimeException.class, () -> {
			list.add(1);
		});
	}
}
