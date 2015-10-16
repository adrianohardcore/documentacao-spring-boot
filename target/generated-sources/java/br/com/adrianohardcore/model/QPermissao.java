package br.com.adrianohardcore.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPermissao is a Querydsl query type for Permissao
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPermissao extends EntityPathBase<Permissao> {

    private static final long serialVersionUID = 427854075L;

    public static final QPermissao permissao = new QPermissao("permissao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nomePermissao = createString("nomePermissao");

    public QPermissao(String variable) {
        super(Permissao.class, forVariable(variable));
    }

    public QPermissao(Path<? extends Permissao> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPermissao(PathMetadata<?> metadata) {
        super(Permissao.class, metadata);
    }

}

