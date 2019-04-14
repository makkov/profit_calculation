CREATE TABLE "category" (
	"id" SERIAL NOT NULL,
	"name" VARCHAR NOT NULL UNIQUE,
PRIMARY KEY ("id")
);

CREATE TABLE "product" (
	"id" SERIAL NOT NULL,
	"category_id" INT NOT NULL,
	"price" INT NOT NULL,
	"date_purchase" VARCHAR NOT NULL,
	"product_sold" BOOLEAN NOT NULL,
PRIMARY KEY ("id")
);

CREATE TABLE "transact" (
	"id" SERIAL NOT NULL UNIQUE,
	"category_id" INT NOT NULL,
	"summ" INT NOT NULL,
	"date_operation" VARCHAR NOT NULL,
PRIMARY KEY ("id")
);

ALTER TABLE "product" ADD CONSTRAINT "product_fk0" FOREIGN KEY ("category_id") REFERENCES "category"("id");

ALTER TABLE "transact" ADD CONSTRAINT "transact_fk0" FOREIGN KEY ("category_id") REFERENCES "category"("id");

