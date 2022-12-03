import { readFileSync } from "fs";
import { join } from "path";

async function main() {
	const fileContents = readFileSync(join(__dirname, "./1.in"), {
		encoding: "utf-8",
	});

	const sorted = fileContents
		.split("\n\n")
		.map((s) =>
			s
				.split("\n")
				.map((n) => Number(n))
				.reduce((prev, curr) => prev + curr),
		)
		.reduce((prev, next) => (prev > next ? prev : next));
	console.log(sorted);
}

main();
