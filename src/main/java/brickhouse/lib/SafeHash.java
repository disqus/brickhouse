package brickhouse.lib;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class SafeHash {
	public SafeHash() {
	}

	boolean hashMethodExists = false;

	private HashFunction hash = Hashing.md5();

	public HashCode hashString( String str) {
		HashCode hc;
		try {
			hc = hash.hashString(str);
		} catch (NoSuchMethodError e) {
			hc = hash.hashUnencodedChars(str);
		}
		return hc;
	}

}
