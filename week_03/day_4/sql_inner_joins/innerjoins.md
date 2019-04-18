# Joining data together

> Setup for this lesson

```bash
mkdir joins_one_to_many
cd joins_one_to_many
cp ~/Downloads/pizza_shop.sql
dropdb pizza_shop
createdb pizza_shop
psql -d pizza_shop -f pizza_shop.sql
touch queries.sql
```

In our Pizza Shop example, we linked the customers to a pizza order through the `customer_id`, but we didn't have an easy way to see that information all together.

Say for example, we wanted to view a list of customer names with the relevant information about their pizza order.

We could do it, but we'd have to use multiple queries.

It is possible to do in one query, we just need to add a new tool to our toolbelt to make this happen - joins.

## Joins

When we join data, there's a few different ways we can approach it but the one thing that really matters is that there has to be some commonality between the tables. In our case, we have the customer id linking the two tables and we can use this to do some interesting things.

With joins, we think in terms of a 'right' column and a 'left' column. These can be any table you like, but it's worth being clear in your head which one you are talking about.

Let's say the `customers` table is the 'left' table and the `pizza_orders` table is the 'right table'.

You can think of a join query as giving us back a sort of 'middle' view that takes data from both sides and combines it.

We might want to:
- find a match between the columns in both tables using a common key => INNER JOIN
- return all rows from the left table (`customers`), with the matching rows in the right table (`pizza_orders`). The result is NULL in the right side when there is no match. => LEFT JOIN
- return all rows from the right table (`pizza_orders`), with the matching rows in the left table (`customers`). The result is NULL in the left side when there is no match. => RIGHT JOIN

The first option is the most common and that's what we are going to look at just now.

## Explicitly Naming Tables

Sometimes when writing our queries, we want to make it clear which tables we're working with. Let's look at a really simple example:

```sql
-- psql
SELECT topping FROM pizza_orders;
```

We can explicitly name the table like so:

```sql
SELECT pizza_orders.topping FROM pizza_orders;
```

This helps when we have tables with the same property e.g. id or name etc. We can make it very clear which table we want to use.

This will be incredibly useful when we make joins between tables, as it will help
us keep track of which tables have which properties.

## INNER JOIN

INNER JOIN syntax is pretty weird, but hang in there and we'll be okay.

Let's see if we can list all of the customers with their relevant pizza order data.

STEP ONE: Select the columns from the left hand table, using an alias.

```sql
SELECT customers.* FROM customers;
```

STEP TWO: Introduce the right hand table you want to bring into the join and the common property you want to match on

```sql
SELECT customers.* FROM customers
INNER JOIN pizza_orders
ON customers.id = pizza_orders.customer_id;
```

Notice that it's only matched Colin and Debbie, there is no sign of Stevie. This is because there is no entry for him in the `pizza_orders` table.

There's also no sign of the columns from the `pizza_orders` table! How do you think we can fix this?

STEP THREE: Bring in the columns from the right hand table

```sql
SELECT customers.*, pizza_orders.* FROM customers
  INNER JOIN pizza_orders
  ON customers.id = pizza_orders.customer_id;
```

There is our data!

[TASK]: See if you can return only the customer name and pizza topping from the join.

```sql
SELECT customers.name, pizza_orders.topping FROM customers
  INNER JOIN pizza_orders
  ON customers.id = pizza_orders.customer_id;
```

## Left (Outer) Join

I mentioned earlier that we might want to do a query where we return all the rows from the left table (`customers`), with the matching rows in the right table (`pizza_orders`). In this case, any customer with no matching pizza order will have values shown as null for those columns.

```sql
SELECT customers.*, pizza_orders.* FROM customers
  LEFT JOIN pizza_orders
  ON customers.id = pizza_orders.customer_id;
```

Right joins are exactly the same, but with the tables swapped around. It doesn't matter for our pizza orders, since every single pizza order is owned by a customer so there is never a case where a null would be shown.