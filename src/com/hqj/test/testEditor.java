/**
 * 
 */
package com.hqj.test;

import org.junit.Test;

import com.hqj.model.Editor;
import com.hqj.serviceimpl.EditorServiceImpl;

/**
 * @author HuangQinJian 下午5:49:37 2017年7月3日
 */
public class testEditor {
	EditorServiceImpl eImpl = new EditorServiceImpl().getInstance();

	@Test
	public void add() {
		Editor editor = new Editor();
		editor.setEditname("huang");
		editor.setEditpass("456");
		if (eImpl.add(editor))
			System.out.println("yes");
		else
			System.out.println("no");
	}

	@Test
	public void search() {
		// if (eImpl.search("qin", "123"))
		// System.out.println("yes");
		// else
		// System.out.println("no");
		// if (eImpl.search("huang", "456"))
		// System.out.println("yes");
		// else
		// System.out.println("no");
		// if (eImpl.search("qin", "456"))
		// System.out.println("yes");
		// else
		// System.out.println("no");
		if (eImpl.search("huang", "123"))
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
