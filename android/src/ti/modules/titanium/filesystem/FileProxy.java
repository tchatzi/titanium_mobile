package ti.modules.titanium.filesystem;

import java.io.IOException;
import java.util.List;

import org.appcelerator.titanium.TiBlob;
import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.TiProxy;
import org.appcelerator.titanium.io.TiBaseFile;
import org.appcelerator.titanium.io.TiFileFactory;

public class FileProxy extends TiProxy
{

	String path;
	TiBaseFile tbf; // The base file object.

	public FileProxy(TiContext tiContext, String[] parts) {
		super(tiContext);

		tbf = TiFileFactory.createTitaniumFile(tiContext, parts, false);
	}

	private FileProxy(TiContext tiContext, TiBaseFile tbf) {
		super(tiContext);
		this.tbf = tbf;
	}

	public boolean isFile() {
		return tbf.isFile();
	}

	public boolean isDirectory() {
		return tbf.isDirectory();
	}

	public boolean isReadonly() {
		return tbf.isReadonly();
	}

	public boolean isWriteable() {
		return tbf.isWriteable();
	}

	public boolean copy (String destination) throws IOException {
		return tbf.copy(destination);
	}

	public void createDirectory(boolean recursive) {
		tbf.createDirectory(recursive);
	}

	public boolean deleteDirectory(boolean recursive) {
		return tbf.deleteDirectory(recursive);
	}

	public boolean deleteFile() {
		return tbf.deleteFile();
	}

	public boolean exists() {
		return tbf.exists();
	}

	public String extension() {
		return tbf.extension();
	}

	public String[] getDirectoryListing()
	{
		List<String> dl = tbf.getDirectoryListing();
		return dl != null ? dl.toArray(new String[0]) : null;
	}

	public FileProxy getParent()
	{
		TiBaseFile bf = tbf.getParent();
		return bf != null ? new FileProxy(getTiContext(), bf) : null;
	}

	public boolean move(String destination)
		throws IOException
	{
		return tbf.move(destination);
	}

	public String name() {
		return tbf.name();
	}

	public String nativePath() {
		return tbf.nativePath();
	}

	public TiBlob read()
		throws IOException
	{
		return tbf.read();
	}

	public String readLine()
		throws IOException
	{
		return tbf.readLine();
	}

	public boolean rename(String destination)
	{
		return tbf.rename(destination);
	}

	public double size() {
		return tbf.size();
	}

	public void write(TiBlob blob, boolean append)
		throws IOException
	{
		tbf.write(blob, append);
	}

	public void write(String data, boolean append)
		throws IOException
	{
		tbf.write(data, append);
	}

	public void writeLine(String data)
		throws IOException
	{
		tbf.writeLine(data);
	}
}