package com.jongh.star.file;

import java.util.List;

public interface FileMapper {
	public abstract int regFile(File file);
	public abstract int deleteFile(File file);
	public abstract int updateFile(File file);
	public abstract int updateFileFile(File file);
	public abstract List<File> getAllFile();
	public abstract List<File> getSearchFile(File file);
	public abstract File getFile();
	public abstract File getFileNo(File file);
}
