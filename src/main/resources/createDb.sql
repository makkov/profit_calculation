CREATE TABLE "category" (
	"id" SERIAL NOT NULL,
	"name" VARCHAR NOT NULL UNIQUE,
PRIMARY KEY ("id")
);

CREATE TABLE "product" (
	"id" SERIAL NOT NULL,
	"category_id" INT NOT NULL,
	"price_purchase" INT NOT NULL,
	"date_purchase" VARCHAR NOT NULL,
	"price_demand" INT,
	"date_demand" VARCHAR,
PRIMARY KEY ("id")
);

ALTER TABLE "product" ADD CONSTRAINT "product_fk0" FOREIGN KEY ("category_id") REFERENCES "category"("id");

