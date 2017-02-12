package testpkg;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TryIt {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("wazzup", "howdy", "hi", "hello");
		List<String> target = list.stream()
				.filter(s->s.startsWith("h"))
				.sorted()
				.collect(Collectors.toList());
		System.out.println(target);
	}
}

