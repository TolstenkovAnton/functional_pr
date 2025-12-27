:- encoding(utf8).

:- op(1200, xfx, '-->').

translate((Head --> Body), Clause) :-
    add_args(Head, S0, S, NewHead),
    process(Body, S0, S, NewBody),
    Clause =.. [':-', NewHead, NewBody].

add_args(Head, A1, A2, NewHead) :-
    Head =.. [F|Args],
    append(Args, [A1, A2], NewArgs),
    NewHead =.. [F|NewArgs].

process((A, B), S0, S, (GA, GB)) :- !,
    process(A, S0, S1, GA),
    process(B, S1, S, GB).

process((A; B), S0, S, (GA; GB)) :- !,
    process(A, S0, S, GA),
    process(B, S0, S, GB).

process([], S, S, true) :- !.
process([W], S0, S, true) :- !, S0 = [W|S].
process([W|Ws], S0, S, true) :- append([W|Ws], S, S0), !.
process(T, S0, S, G) :- add_args(T, S0, S, G).

test :-
    format('Тест 1: '),
    translate((s --> np, vp), C1),
    write(C1), nl,
    
    format('Тест 2: '),
    translate((det --> [the]), C2),
    write(C2), nl,
    
    format('Тест 3: '),
    translate((vp --> v; (v, np)), C3),
    write(C3), nl,
    
    format('Готово!~n').

main :- test.

:- initialization(main).